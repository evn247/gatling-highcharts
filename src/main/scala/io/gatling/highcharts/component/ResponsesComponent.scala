/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Gatling Highcharts License
 */
package io.gatling.highcharts.component

import io.gatling.core.result.{ IntVsTimePlot, PieSlice, Series }
import io.gatling.highcharts.series.{ NumberPerSecondSeries, PieSeries }
import io.gatling.highcharts.template.ResponsesTemplate

object ResponsesComponent {

	def apply(runStart: Long, allResponses: Series[IntVsTimePlot], failedResponses: Series[IntVsTimePlot], succeededResponses: Series[IntVsTimePlot], pieSeries: Series[PieSlice]) = {
		val template = new ResponsesTemplate(
			Seq(new NumberPerSecondSeries(allResponses.name, runStart, allResponses.data, allResponses.colors.head),
				new NumberPerSecondSeries(failedResponses.name, runStart, failedResponses.data, failedResponses.colors.head),
				new NumberPerSecondSeries(succeededResponses.name, runStart, succeededResponses.data, succeededResponses.colors.head)),
			new PieSeries(pieSeries.name, pieSeries.data, pieSeries.colors))

		new HighchartsComponent(template)
	}
}
