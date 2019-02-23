import {Component} from "react";
import React from "react";
import SimpleTable from "./SimpleTable";
import MUIDataTable from "mui-datatables";

class Selections extends Component {

  constructor(props) {
    super(props);
    this.state = {
      predictions: []
    }
  }

  componentDidMount() {
    fetch('predictions/latest')
      .then(response => response.json())
      .then(data => this.setState({predictions: data.predictions}))
  }

  render() {
    let data = [];
    let columns = [];
    const options = {
      filterType: "dropdown",
      responsive: "scroll",
      selectableRows: false
    };
    columns.push("Date", "League", "Home Team", "Home Team Score", "Away Team Score", "Away Team", "Recommended Bets");
    this.state.predictions.forEach((prediction) => {
      data = [...data, [prediction.startTime, prediction.league, prediction.homeTeam, Number(prediction.homeTeamScore).toFixed(1), Number(prediction.awayTeamScore).toFixed(1), prediction.awayTeam, prediction.recommendedBets.toString()]];
    });
    if (data.length === 0) return null;
    console.log(columns);
    console.log(data);
    return (
      <div>
        {/*<SimpleTable predictions={this.state.predictions}/>*/}
        <MUIDataTable
          title={"Latest Predictions"}
          data={data}
          columns={columns}
          options={options}
        />
      </div>
    );
  }
}

export default Selections;