import React, { Component } from "react";
// import axios from "axios";
import './MovieList.css';


// use WebXmlRequest to handle apis
var xhr;


class MovieList extends Component {

    /*
        MovieList Component has a constructor which inherits react props.

        1) Declare states
        2) Bind functions like genreLabel and toMovie to this props.
     */
    constructor(props) {
        super(props);

        // state has the function to
        this.state = { movies: [] }

        this.toMovie = this.toMovie.bind(this);
        this.sendFetchMovieRequest = this.sendFetchMovieRequest.bind(this);
        this.processRequest = this.processRequest.bind(this);
        // this sendFetchMovieRequest API will be called in the MovieForm.js component
        this.props.eventDispatcher.subscribe("sendFetchMovieRequest", this.sendFetchMovieRequest);
    }



    // fetch the movie via sendFetchMovieRequest API  and  update the React state
    componentDidMount() {
        this.sendFetchMovieRequest()
    }

    sendFetchMovieRequest() {
        xhr = new XMLHttpRequest();
        xhr.open("GET", "http://localhost/movies");
        xhr.send();
        xhr.addEventListener("readystatechange", this.processRequest, false);
    }

    processRequest() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText)
            var response = JSON.parse(xhr.responseText);

            // set the React state with the fetched movie list
            this.setState({
                movies: response
            })
        }
    }



    // update the React state from
    toMovie(movieJson) {
        var genreMapped = "?";    // not sure what genre the inserted movie object

        for (var i = 0; i < this.props.genres.length; i++) {
            if (this.props.genres[i].value == movieJson.genre) {
                genreMapped = this.props.genres[i].label;
                break;
            }
        }

        return (
            <tbody key={movieJson.id}>
                <tr>
                    <td>{movieJson.title}</td>
                    <td>{genreMapped}</td>
                </tr>
            </tbody>
        )
    }

    render() {
        return (
            <table className="movie-list" >
                <tbody>
                <tr>
                    <th>Name</th>
                    <th>Genre</th>
                </tr>
                </tbody>
                {/* for each movie from the movies list,
                    toMovie function takes the movie JSON object and map the genres
                */}
                {this.state.movies.map(this.toMovie)}
            </table>
        )
    }

}

export default MovieList;