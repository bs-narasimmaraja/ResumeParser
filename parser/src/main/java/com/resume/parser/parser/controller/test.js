function processMessages(messages) {
    messages.forEach(message => {
      const { type, payload } = message;
  
      switch (type) {
        case "create":
          const { itemname, quant } = payload;
          console.log(`Creating item: ${itemname} with quantity: ${quant}`);
          break;
  
        case "update":
          // Handle update logic here
          console.log("Updating item");
          break;
  
        case "delete":
          // Handle delete logic here
          console.log("Deleting item");
          break;
  
        default:
          console.log("Unsupported message type:", type);
      }
    });
  }
  const messages = [
    {"type":"create","payload":{"itemname":"book","quant":100}},
    {"type":"modify","payload":{"itemid":123,"action":"subtract","amount":4}},

    {"type":"query","payload":{"queryType":"availability","queryvalue":"hi"}},
    
  ];
  
  processMessages(messages);