import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const styles = theme => ({
  root: {
    width: '100%',
    marginTop: theme.spacing.unit * 3,
    overflowX: 'auto',
  },
  table: {
    minWidth: 700,
  },
});

const SimpleTable = (props) => {
  const { classes, predictions } = props;
  return (
    <Paper className={classes.root}>
      <Table className={classes.table}>
        <TableHead>
          <TableRow>
            <TableCell>Date</TableCell>
            <TableCell align="right">League</TableCell>
            <TableCell align="right">Fixture</TableCell>
            <TableCell align="right">Prediction</TableCell>
            <TableCell align="right">Recommended Bets</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {predictions.map((prediction, i) => (
            <TableRow key={i}>
              <TableCell component="th" scope="row">
                {prediction.startTime}
              </TableCell>
              <TableCell align="right">{prediction.league}</TableCell>
              <TableCell align="right">{prediction.homeTeam} v {prediction.awayTeam}</TableCell>
              <TableCell align="right">{Number(prediction.homeTeamScore).toFixed(1)}-{Number(prediction.awayTeamScore).toFixed(1)}</TableCell>
              <TableCell align="right">{prediction.recommendedBets}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </Paper>
  );
};

SimpleTable.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SimpleTable);