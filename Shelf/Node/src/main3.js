import * as THREE from 'three';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader.js';

const renderer = new THREE.WebGLRender();
renderer.setSize( window.innerWidth - 200, window.innerHeight - 200 );
document.body.appendChild( renderer.domElement );

const loader = new GLTFLoader();
const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 0.1, 1000 );
camera.position.set( 0, 0, 100 );
camera.lookAt( 0, 0, 0 );

loader.load( 'src/resources/toyota_supra_dekztrax_persephone_34.glb', function ( gltf ) {
  scene.add( gltf.scene );
}, undefined, function ( error ) {
  console.error( error );
} );

renderer.render( scene, camera );

function animate() {
  requestAnimationFrame( animate );
  renderer.render( scene, camera );
}
animate();
