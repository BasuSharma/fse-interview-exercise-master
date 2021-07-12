import React, { Component } from "react";
import EligibilityApplication from "./EligibilityApplication";
import EligibilityResults from "./EligibilityResults";
import { REST_API_SERVER_URL } from "../../Configuration/ApplicationConstants"
import ErrorPage from "./ErrorPage/ErrorPage";

interface AppProps {

}
interface AppState {
  cardsStatus: boolean,
  userName: string,
  cards: Object
  statusError: boolean

}

//Container compoenent for handling form action and showing results
class EligibilityContainer extends Component<AppProps, AppState> {
  constructor(props: any) {
    super(props);
    // Set initial state
    this.state = {
      cardsStatus: false,
      userName: "",
      cards: {},
      statusError: false
    }
  }


  // funciton to handle form submit action of child component 
  checkApplicantEligiblity = (values: any) => {
    this.setState({ userName: values.name })
    fetch(REST_API_SERVER_URL, {
      "method": "POST",
      "headers": {
        "content-type": "application/json",
        "accept": "application/json"
      },
      "body": JSON.stringify({
        name: values.name,
        email: values.email,
        address: values.address
      })
    })
      .then(response => response.json())
      .then(response => {
        if (!(response.cards === undefined) && !(response.cards === null)) {
          this.setState({
            cardsStatus: true,
            cards: response.cards
          })
        }
        else {
          throw new Error("error");
        }
      })
      .catch(err => {
        console.log(err);
        this.setState({ statusError: true })
      })
  }

// conditional rendering for form, results and error scenarios
  render() {

    if (!this.state.cardsStatus && !this.state.statusError) {
      return (<EligibilityApplication checkApplicantEligiblity={this.checkApplicantEligiblity} />);
    }
    else if (this.state.cardsStatus && !this.state.statusError) {
      return (<EligibilityResults userName={this.state.userName} cards={this.state.cards} />);
    }
    else {
      return (<ErrorPage />);
    }
  }
}

export default EligibilityContainer;