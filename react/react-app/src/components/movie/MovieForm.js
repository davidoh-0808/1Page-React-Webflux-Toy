import React, { Component } from "react";
import axios from "axios";
import './MovieForm.css';

//new
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
        this.state = { title: '', genre: 'action' };

    }

}

export default MovieForm;