import discord
import logging
import os

from base import Message, Conversation
from constants import generate_constants
import json
import requests
from utils import *

intents = discord.Intents.default()
intents.message_content = True
client = discord.Client(intents = intents)
tree = discord.app_commands.CommandTree(client)

logging.basicConfig(
    format="[%(asctime)s] [%(filename)s:%(lineno)d] %(message)s", level=logging.INFO
)
logger = logging.getLogger(__name__)

def get_quote():
    response = requests.get("https://zenquotes.io/api/random")
    json_data = json.loads(response.text)
    quote = json_data[0]['q'] + " -" + json_data[0]['a']
    return(quote)

@client.event
async def on_ready():
    logger.info(f"We have logged in as {client.user}.")

@client.event
async def on_message(message: DiscordMessage):
    try:
        if message.author == client.user:
            return

        if message.content.startswith('$hello'):
            quote = get_quote();
            await message.channel.send(quote)

    except Exception as e:
        logger.exception(e)


dscrd_bot_token, dscrd_bot_url = generate_constants()
client.run(dscrd_bot_token)
