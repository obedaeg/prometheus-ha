package com.test.health

import org.springframework.boot.actuate.health.Health

import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator
import org.springframework.stereotype.Component
import javax.sql.DataSource


@Component
class CustomDbHealth(dataSource: DataSource?) : DataSourceHealthIndicator(dataSource, "SELECT CURRENT_DATE") {

}