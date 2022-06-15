App = {

  init: async function() {
    // Load pets.
    $.getJSON('./resources/pets.json', function(data) {
      var petsRow = $('#petsRow');
      var petTemplate = $('#petTemplate');
		//var msg= "";
      for (i = 0; i < data.length; i ++) {
		//msg+=data[i].id+"\t"+data[i].name +"\t"+ data[i].picture+"\t"+data[i].age+"\t"+data[i].breed+"\t"+data[i].location+"\n";
        petTemplate.find('.panel-title').text(data[i].name);
        petTemplate.find('img').attr('src', "resources/"+data[i].picture);
        petTemplate.find('.pet-breed').text(data[i].breed);
        petTemplate.find('.pet-age').text(data[i].age);
        petTemplate.find('.pet-location').text(data[i].location);
        petTemplate.find('.btn-adopt').attr('data-id', data[i].id);

        petsRow.append(petTemplate.html());
      }
		//console.log(msg);
    });

    return await App.initContract();
  },

  initContract: function() {
	App.markAdopted();
    return App.bindEvents();
  },

  bindEvents: function() {
    $(document).on('click', '.btn-adopt', App.handleAdopt);
  },

  markAdopted: function() {
    fetch('./resources/adopted.json')
    .then(response => response.json() )
	.then(function(adopters) {
      for (i = 0; i < adopters.length; i++) {
        $('.panel-pet').eq(adopters[i]).find('button').text('Success').attr('disabled', true);
      }
    }).catch(function(err) {
      console.log(err.message);
    });
  },

  handleAdopt: function(event) {
    event.preventDefault();

    var petId = parseInt($(event.target).data('id'));

	fetch('')
	  .then(function(instance) {
        
        // Execute adopt as a transaction by sending account
        //return adoptionInstance.adopt(petId, {from: account});
      }).then(function(result) {
        return App.markAdopted();
      }).catch(function(err) {
        console.log(err.message);
      });
  }

};

$(function() {
  $(window).load(function() {
    App.init();
  });
});

