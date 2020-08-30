const express = require('express');
const mongoose = require('mongoose');
require('dotenv').config();
const app= express();
const bodyParser = require('body-parser')
const cors = require('cors');

// setup
mongoose.connect(process.env.DB_CONNECTION ||  `mongodb://${process.env.DB_USER}:${process.env.DB_PWD}@localhost:20017/corona-db`,{ useNewUrlParser: true, useUnifiedTopology: true },(res) => console.log(res || 'db connected!'));
app.use(cors())
app.use(bodyParser.json());


//routing
const postsRoute = require('./route/posts');
app.use('/posts', postsRoute);

// start listening
app.listen(3000);

