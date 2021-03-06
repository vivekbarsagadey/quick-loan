// Get dependencies
const express = require('express');
const path = require('path');
const http = require('http');
const winston = require('winston');
const bodyParser = require('body-parser');

// Get our API routes
const api = require('./server/routes/api');
const user = require('./server/routes/user-controller');
const cors = require('cors');
const app = express();
app.use(cors());

const optimist = require('optimist')
  .alias('h', 'help')
  .describe('createSchema', 'ReCreate Database schema')
  .describe('update', 'Update all machine data')
  .describe('query', 'Query and list all machine data')
  .usage('Knex Sample tests');

const logger = winston.createLogger({
  level: 'info',
  format: winston.format.json(),
  transports: [
    //
    // - Write to all logs with level `info` and below to `combined.log`
    // - Write all logs error (and below) to `error.log`.
    //
    new winston.transports.File({ filename: 'error.log', level: 'error' }),
    new winston.transports.File({ filename: 'combined.log' })
  ]
});

// Parsers for POST data
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

// Point static path to dist
app.use(express.static(path.join(__dirname, 'dist')));
app.use(express.static(path.join(__dirname, 'dist/uplportal/')));
app.use(express.static(__dirname + '/node_modules/'));

// Set our api routes
app.use('/api', api);

// Catch all other routes and return the index file
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'dist/uplportal/index.html'));
});



// Handle authentication request
app.use('/api/user', user);


/**
 * Get port from environment and store in Express.
 */
const port = process.env.PORT || '8088';
app.set('port', port);

/**
 * Create HTTP server.
 */
const server = http.createServer(app);

/**
 * Listen on provided port, on all network interfaces.
 */
server.listen(port, () => console.log(`API running on localhost:${port}`));
