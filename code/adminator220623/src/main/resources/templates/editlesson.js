new Vue({
  el: '#app',
  vuetify: new Vuetify(),
  data: () => ({
    dialog: false,
    headers: [
    {
      text: 'Lesson Name',
      align: 'left',
      sortable: false,
      value: 'name' },

    { text: 'Lesson ID', value: 'ID' },
    { text: 'Duration', value: 'time' },
    { text: 'Status', value: 'stituation' },
    { text: 'Actions', value: 'action', sortable: false }],

    desserts: [],
    editedIndex: -1,
    editedItem: {
      name: '',
      ID: 0,
      time: 0,
      stituation: '',
    },

    defaultItem: {
      name: '',
      ID: 0,
      time: 0,
      stituation: '',
  } }),



  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'New Lesson' : 'Edit Lesson';
    } },


  watch: {
    dialog(val) {
      val || this.close();
    } },


  created() {
    this.initialize();
  },

  methods: {
    initialize() {
      this.desserts = [
      {
        name: 'The History of the Internet',
        ID: 159,
        time: 6.0,
        stituation: 'Active',
 },

      {
        name: 'How to Code in Python',
        ID: 237,
        time: 9.0,
        stituation: 'Offline',
 },

      {
        name: 'The Art of Public Speaking',
        ID: 262,
        time: 16.0,
        stituation: 'In Progress',
},

      {
        name: 'The Psychology of Persuasion',
        ID: 305,
        time: 3.7,
        stituation: 'Active',
},

      {
        name: 'The Science of Happiness',
        ID: 356,
        time: 16.0,
        stituation: 'Offline',
},

      {
        name: 'The Power of Mindset',
        ID: 375,
        time: 0.0,
        stituation: 'In Progress',
   },

];


    },

    editItem(item) {
      this.editedIndex = this.desserts.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      const index = this.desserts.indexOf(item);
      confirm('Are you sure you want to delete this item?') && this.desserts.splice(index, 1);
    },

    close() {
      this.dialog = false;
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      }, 300);
    },

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.desserts[this.editedIndex], this.editedItem);
      } else {
        this.desserts.push(this.editedItem);
      }
      this.close();
    } } });