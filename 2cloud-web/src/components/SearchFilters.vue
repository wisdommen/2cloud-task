<template>
  <v-container>
    <v-row>
      <div v-for="each in Object.keys(filters)" class="selector-wrapper">
        <v-menu v-if="each === 'year' || each === 'odometer'" :close-on-content-click="false">
          <template v-slot:activator="{ props }">
            <v-btn
              v-bind="props"
              class="btn d-flex"
              variant="outlined"
              height="40"
              block
              style="background: white; border-color: #939393; justify-content: space-between !important;"
            >
              <p class="text-grey-darken-1 text-subtitle-1 me-auto">
                {{ filters[each].title }}
              </p>
              <template v-slot:append>
                <v-icon class="align-self-center text-grey-darken-1" size="x-large">mdi-menu-down</v-icon>
              </template>
            </v-btn>
          </template>
          <v-sheet width="260" class="pa-5">
            <v-container>
              <v-row>
                <v-text-field v-model="filters[each].items[0]" label="min" variant="outlined" class="pr-2"/>
                <v-text-field v-model="filters[each].items[1]" label="max" variant="outlined"/>
              </v-row>
              <v-row>
                <v-range-slider :strict="true" v-model="filters[each].items" :step="1"></v-range-slider>
              </v-row>
            </v-container>
          </v-sheet>
        </v-menu>
        <v-menu v-else-if="each === 'sale_date'" :close-on-content-click="false">
          <template v-slot:activator="{ props }">
            <v-btn
              v-bind="props"
              class="btn d-flex"
              variant="outlined"
              height="40"
              style="background: white; border-color: #939393; justify-content: space-between !important;"
              block
            >
                <p class="text-grey-darken-1 text-subtitle-1">
                  {{ filters[each].title }}
                </p>
                <template v-slot:append>
                  <v-icon class="align-self-center text-grey-darken-1" size="x-large">mdi-menu-down</v-icon>
                </template>
            </v-btn>
          </template>
          <v-sheet width="260" class="pa-5">
            <v-container>
              <v-row>
                <v-radio-group v-model="filters[each].select">
                  <v-radio label="Last 7 days" :value="7"/>
                  <v-radio label="Last 30 days" :value="30"/>
                  <v-radio label="Last 90 days" :value="90"/>
                </v-radio-group>
              </v-row>
              <v-row>
                <v-text-field :readonly="true" label="Min" v-model="filters[each].display_date.min"
                              variant="underlined">
                  <template v-slot:append>
                    <v-menu :close-on-content-click="false">
                      <template v-slot:activator="{ props }">
                        <v-btn v-bind="props" variant="plain" size="small">
                          <v-icon>mdi-calendar-today</v-icon>
                        </v-btn>
                      </template>
                      <v-date-picker v-model="filters[each].items[0]" hide-header>
                      </v-date-picker>
                    </v-menu>
                  </template>
                </v-text-field>
              </v-row>
              <v-row>
                <v-text-field :readonly="true" label="Max" v-model="filters[each].display_date.max"
                              variant="underlined">
                  <template v-slot:append>
                    <v-menu :close-on-content-click="false">
                      <template v-slot:activator="{ props }">
                        <v-btn v-bind="props" variant="plain" size="small">
                          <v-icon>mdi-calendar-today</v-icon>
                        </v-btn>
                      </template>
                      <v-date-picker v-model="filters[each].items[1]" hide-header>
                      </v-date-picker>
                    </v-menu>
                  </template>
                </v-text-field>
              </v-row>
            </v-container>
          </v-sheet>
        </v-menu>
        <v-select v-else :label="filters[each].title" :items="filters[each].items" class="btn"
                  variant="outlined" density="compact" bg-color="white">
          <template v-slot:item="{ props, item }">
            <v-list-item v-bind="props">
              {{ filters[each].items }}
            </v-list-item>
          </template>
        </v-select>
      </div>
    </v-row>
    <v-row>
      <div class="text-filed pl-1 pr-2">
        <v-text-field placeholder="e.g. Metallic Paint,Power front seats,Power Sunroof, ..." variant="outlined" density="compact" bg-color="white"/>
      </div>
      <div class="btn-primary px-2">
        <v-btn :block="true" class="btn btn-color-primary" height="40">Apply Filter</v-btn>
      </div>
      <div class="btn-primary px-2">
        <v-btn :block="true" class="btn btn-color-primary" height="40">Clear Filter</v-btn>
      </div>
      <div class="btn-subscribe px-2 hidden-md-and-down">
        <v-btn :block="true" class="btn btn-color-red" height="40">Subscribe to Generate Summary Report</v-btn>
      </div>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "SearchFilters",
  data: () => ({
    filters: {
      make: {
        title: "Make",
        items: [],
      },
      model: {
        title: "Model",
        items: [],
      },
      year: {
        title: "Year",
        items: [0, 0],
        value: {
          min: 0,
          max: 0,
        }
      },
      badge: {
        title: "Badge",
        items: [],
      },
      body_type: {
        title: "Body Type",
        items: [],
      },
      body_type_config: {
        title: "Body Type Config",
        items: [],
      },
      fuel: {
        title: "Fuel",
        items: [],
      },
      transmission: {
        title: "Transmission",
        items: [],
      },
      engine: {
        title: "Engine",
        items: [],
      },
      cylinders: {
        title: "Cylinders",
        items: [],
      },
      division: {
        title: "Division",
        items: [],
      },
      drive: {
        title: "Drive",
        items: [],
      },
      seat: {
        title: "Seat",
        items: [],
      },
      doors: {
        title: "Doors",
        items: [],
      },
      odometer: {
        title: "Odometer",
        items: [0, 0],
        value: {
          min: 0,
          max: 0,
        }
      },
      states: {
        title: "States",
        items: [],
      },
      sale_type: {
        title: "Sale Type",
        items: [],
      },
      sale_date: {
        title: "Sale Date",
        items: [new Date(), new Date()],
        display_date: {
          min: '',
          max: '',
        },
        select: 0
      },
      sort_by: {
        title: "Sort By",
        items: [],
      },
      order_by: {
        title: "Order By",
        items: ["ASC", "DESC"],
      },
    }
  }),
  methods: {
    formatDate(date) {
      let day = date.getDate();
      let month = date.getMonth() + 1;
      let year = date.getFullYear();

      day = day < 10 ? '0' + day : day;
      month = month < 10 ? '0' + month : month;

      return `${day}/${month}/${year}`;
    }
  },
  watch: {
    'filters.sale_date.select': function (val) {
      let min = new Date()
      let max = new Date()
      min.setDate(new Date().getDate() - val)
      this.filters.sale_date.items[0] = min
      this.filters.sale_date.items[1] = max
      this.filters.sale_date.display_date.min = this.formatDate(min)
      this.filters.sale_date.display_date.max = this.formatDate(max)
    },
    'filters.sale_date.items': {
      deep: true,
      handler: function (val) {
        this.filters.sale_date.display_date.min = this.formatDate(val[0])
        this.filters.sale_date.display_date.max = this.formatDate(val[1])
      }
    }
  }
}
</script>

<style>
.selector-wrapper {
  width: 160px;
  height: 50px;
  padding-inline: 5px;
  padding-bottom: 5px;
}

@media screen and (max-width: 1128px) {
  .selector-wrapper {
    width: 100%;
  }
}

.btn-primary {
  width: 117px;
}

.btn-subscribe{
  width: 350px;
}

.text-filed {
  width: 500px;
}

.btn-color-primary {
  color: #fff;
  background-color: #00a0df;
  border-color: #00a0df;
}
.btn-color-red {
  background: #ff5a60;
  color: #fff!important;
  font-weight: 500!important;
  border: 1px solid #ff5a60!important;
}
</style>
