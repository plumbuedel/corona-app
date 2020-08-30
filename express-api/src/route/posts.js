const express = require('express');
const router = express.Router();
const PostRepository = require('../models/postModel');





router.get('/', async (req, res) => {
   try {

    const posts = await PostRepository.find();
    res.json(posts);
   } catch(err) {
       res.json({message: err});
   }
})

router.get('/:postId', async(req, res) => {
    try {
        const result = await PostRepository.findById(req.params.postId);
        res.json(result);
    }  catch(err) {
        res.json({message: err});
    }
})

router.post('/', /*async*/ (req, res) => {
    const newPost = new PostRepository({
        title: req.body.title,
        description: req.body.description
    });

    // try {
    //     const savedPost = newPost.save();
    //     res.json(savedPost);
    // } catch(err) {
    //     res.json({message: err});
    // }

    newPost.save().then(data => {
        res.json(data);
    }).catch(err => {
        res.json({message: err});
    });
});

router.delete('/:postId',async (req, res) => {
    try {
        const result  = await PostRepository.remove({
            _id: req.params.postId});
        res.json(result);
    } catch (error) {
        res.json({message: error})
    }
})

router.patch('/:postId',async (req, res) => {
    try {
        const result  = await PostRepository.updateOne(
            {
            _id: req.params.postId
            },
            { $set: 
                {
                title: req.body.title,
                description: req.body.description
                }
            });
        result = {
            title: res
        }
        res.json(result);
    } catch (error) {
        res.json({message: error})
    }
})



module.exports = router;