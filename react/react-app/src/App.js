import React from 'react';
import './App.css';
import MovieList from "./components/movie/MovieList"
import MovieForm from "./components/movie/MovieForm"


// set genres as fixed values
const genres = [
        {value: 'action', label: 'Action'},
        {value: 'comedy', label: 'Comedy'},
        {value: 'drama', label: 'Drama'},
        {value: 'thriller', label: 'Thriller'},
        {value: 'musical', label: 'Musical'}
    ]

/*
    ** use the global event dispatcher to share functions across components
    * which means a function can be defined in one component (subscribe) and used in another (dispatch)
 */
const eventDispatcher = {
        listeners: {},
        dispatch: function(event, data) {
            if(this.listeners[event]) {
                this.listeners[event].forEach(
                    function(listener) {
                        listener(data);
                    }
                );
            }
        },
        subscribe: function(event, func) {
            if(!this.listeners[event]) {
                this.listeners[event] = [];
            }
            this.listeners[event].push(func);
        }
    }

//
function App() {
    return (
        <div className="App">
            <h1>
                Movies
            </h1>
            <div>
                {/* ** inject genres and  event dispatcher */}
                <MovieForm genres={genres} eventDispatcher={eventDispatcher}/>
                <MovieList genres={genres} eventDispatcher={eventDispatcher}/>
            </div>
        </div>
    );
}


export default App;


/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <h1>hello</h1>
      </header>
    </div>
  );
}

export default App;
*/
