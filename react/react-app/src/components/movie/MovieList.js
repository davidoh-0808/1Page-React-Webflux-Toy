import React, { Component } from "react";
import axios from "axios";
import './MovieList.css';

class MovieList extends Component {

    /*
        MovieList Component has a constructor which inherits react props.
        Bind functions like genreLabel and toMovie to this props.
     */
    constructor(props) {
        super(props);
        this.toMovie = this.toMovie.bind(this);
        this.genreLabel = this.genreLabel.bind(this);
    }

    genreLabel(g) {
        return "?";
    }

    toMovie(m) {    // TODO : Fetch  1. movies  2. genres via axios

        var g = "?";
        for (var i = 0; i < this.props.genres.length; i++) {
            if (this.props.genres[i].value == m.genre) {
                g = this.props.genres[i].label;
                break;
            }
        }

        return(
            <tbody key={m.id}>
                <tr>
                    <td>{m.title}</td><td>{g}</td>
                </tr>
            </tbody>
        )
    }

    render() {
        return(
            <table className="movie-list">
                <tbody>
                    <tr>
                        <th>Title</th>
                        <th>Genre</th>
                    </tr>
                </tbody>

                {/* TODO : Fetch  1. movies  2. genres via axios */}
                {this.props.movies.map(this.toMovie(m))}
            </table>
        )
    }

}

export default MovieList;