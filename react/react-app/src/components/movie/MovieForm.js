import React, { Component } from "react";
// import axios from "axios";
import './MovieForm.css';

// use WebXmlRequest to handle apis
var xhr;

class MovieForm extends Component {

    /*
        MovieForm Component has a constructor which inherits react props.
        1. Bind functions like handleChangeTitle and handleChangeGenre to the react props.
        2. Also, the react props provides a set of state which keeps track of the current states
            of variables like "title" and "genre".  Set the state with the variables of the form

        Use
     */
    constructor(props) {
        super(props);

        // React state object
        this.state = { title: '', genre: 'action' };

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleChangeGenre = this.handleChangeGenre.bind(this);
        this.changeState = this.changeState.bind(this);
        this.toGenreOption = this.toGenreOption.bind(this);

        this.createMovie = this.createMovie.bind(this);
        this.processRequest = this.processRequest.bind(this);

    }

    /*
    ** declare functions **
*/

    /* leverage React setState function to re-render UI when state changes
        and Object.assign() function to return an object representing the current state */
    changeState(keyValObj) {
        this.setState(
            Object.assign({}, this.state, keyValObj)
        )
    }

    handleChangeTitle(event) {
        this.changeState( { title: event.target.value } )
    }

    handleChangeGenre(event) {
        this.changeState( { genre: event.target.value } )
    }


    createMovie() {
        xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost/movies")
        xhr.send(
            // make a new movie out of the React state altered via form
            JSON.stringify({ "title": this.state.title, "genre": this.state.genre })
        );
        // *** processRequest function
        xhr.addEventListener("readystatechange", this.processRequest, false);
    }

    // *** reset the React state after the createMovie API is processed
    processRequest() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // use the eventDispatcher to reset .. ??
            this.props.eventDispatcher.dispatch("sendAddMovieRequest", "")
            this.changeState( { title: "" } )
        }
    }

    toGenreOption(g) {
        return (
            <option key={g.value} value={g.value}>{g.label}</option>
        )
    }

    render() {
        return (
            <form className="movie-form">
            <span className="movie-form-element">
                <label>Title&nbsp;
                    {/* use the React state as the value  AND  a function to change that state */}
                    <input type="text" value={this.state.title} onChange={this.handleChangeTitle} />
                </label>
            </span>
                <span className="movie-form-element">
                <label>Genre&nbsp;
                    <select value={this.state.genre} onChange={this.handleChangeGenre}>
                {this.props.genres.map(this.toGenreOption)}
                </select>
                </label>
            </span>
                <span className="movie-form-element">
                <input type="button" value="Submit" onClick={this.createMovie} />
            </span>
            </form>
        )
    }

}

export default MovieForm;