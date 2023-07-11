var products = [
  {id: 1, name: 'Angular', description: 'Superheroic JavaScript MVW Framework.', price: '03/06/2023'},
  {id: 2, name: 'Ember', description: 'A framework for creating ambitious web applications.', price: '03/06/2023'},
  {id: 3, name: 'React', description: 'A JavaScript Library for building user interfaces.', price: '03/06/2023'},
  {id: 4, name: 'Vue', description: 'The Progressive JavaScript Framework using MVVM structure', price: '03/06/2023'}
];

function findProduct (productId) {
  return products[findProductKey(productId)];
};

function findProductKey (productId) {
  for (var key = 0; key < products.length; key++) {
    if (products[key].id == productId) {
      return key;
    }
  }
};

// component --------------------------------------------------------
const List = {
    template: '#product-list',
    data: function () {
      return {products: products, searchKey: ''};
    },
    computed: {
      filteredProducts: function () {
        var self = this;
        return self.products.filter(function (product) {
          return product.name.toLowerCase().indexOf(self.searchKey.toLowerCase()) !== -1
        })
      }
    }
};

const AddProduct = {
    template: '#add-product',
    data: function () {
      return {product: {name: '', description: '', price: ''}
      }
    },
    methods: {
      createProduct: function() {
        var product = this.product;
        products.push({
          id: Math.random().toString().split('.')[1],
          name: product.name,
          description: product.description,
          price: product.price
        });
        router.push('/');
      }
    }
};

const Product = {
    template: '#product',
    data: function(){
        return {product: findProduct(this.$route.params.product_id)};
    }
};

const ProductEdit = {
    template: '#product-edit',
    data: function(){
        return {product: findProduct(this.$route.params.product_id)};
    },
    methods: {
        updateProduct: function(){
            var product = this.product;
            products[findProductKey(product.id)] = {
                id: product.id,
                name: product.name,
                description: product.description,
                price: product.price
            }
            router.push('/');
        }
    }
};

const ProductDelete = {
    template: '#product-delete',
    data: function(){
        return {product: findProduct(this.$route.params.product_id)};
    },
    methods: {
        deleteProduct: function () {
          products.splice(findProductKey(this.$route.params.product_id), 1);
          router.push('/');
        }
    }
}

// router ------------------------------------------------------------
var router = new VueRouter({
    routes: [
        { path: '/', component: List },
        { path: '/product/:product_id', component: Product, name: 'product' },
        { path: '/add-product', component: AddProduct },
        { path: '/product/:product_id/edit', component: ProductEdit, name: 'product-edit' },
        { path: '/product/:product_id/delete', component: ProductDelete, name: 'product-delete' }
    ]
});

// Vue app -----------------------------------------------------------
var app = new Vue({
  el: '#app',
  router: router,
  template: '<router-view></router-view>'
});