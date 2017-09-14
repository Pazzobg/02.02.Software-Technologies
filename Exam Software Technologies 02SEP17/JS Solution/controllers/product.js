const Product = require('../models/Product');

module.exports = {
    index: (req, res) => {
        Product.find().then(products => {
            res.render('product/index', {'entries': products})
        });
    },

    createGet: (req, res) => {
        res.render('product/create');
    },
    createPost: (req, res) => {
        let productArgs = req.body;

        if (!productArgs.priority ||
            !productArgs.name ||
            !productArgs.quantity ||
            !productArgs.status) {
            return res.redirect('/');
        }

        Product.create(productArgs).then(product => {
            res.redirect('/');
        });
    },

    editGet: (req, res) => {
        let id = req.params.id;

        Product.findById(id).then(product => {
            if(product) {
                return res.render('product/edit', product);
            } else {
                return res.redirect('/');
            }
        }).catch(err => res.redirect('/'));
    },
    editPost: (req, res) => {
        let id = req.params.id;
        let product = req.body;

        Product.findByIdAndUpdate(id, product, {runValidators: true}).then(product => {
            res.redirect('/');
        }).catch(err => {
            product.id = id;
            product.error = "Cannot edit product info. Please fill out all fields.";
            return res.render('product/edit', product);
        });
    }
};