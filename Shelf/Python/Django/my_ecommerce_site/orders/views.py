from django.shortcuts import render, redirect, get_object_or_404
from products.models import Product

def add_to_cart(request, product_id):
    cart = request.session.get('cart', {})
    product = get_object_or_404(product, pk=product_id)

    if product_id in cart:
        cart[product_id]['quantity'] += 1
    else:
        cart[product_id] = {
            'product': product,
            'quantity': 1,
        }

    request.session['cart'] = cart
    return redirect('product_list')

# Create your views here.
