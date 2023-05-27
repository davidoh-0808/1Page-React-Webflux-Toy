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

    toMovie(m) {


        return(
            <tbody>
                <tr>
                    <td></td><td></td>
                </tr>
            </tbody>
        )
    }

    render() {
        return(
            <table>
                <tbody>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </tbody>
                {}
            </table>
        )
    }

}

export default MovieList;