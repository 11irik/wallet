<script>
    import {Bar} from 'vue-chartjs';

    export default {
        extends: Bar,

        props: {
            label: String,
            data: Array
        },

        mounted() {
            this.renderChart(
                {
                    labels: this.data[0],
                    datasets: [
                        {
                            label: this.label,
                            backgroundColor: '#f87979',
                            data: this.data[1]
                        }
                    ]
                },
                {responsive: true, maintainAspectRatio: false}
            );
        }
    };
</script>
