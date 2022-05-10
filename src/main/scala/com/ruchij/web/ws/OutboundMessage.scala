package com.ruchij.web.ws

import com.ruchij.services.messages.models.Message
import com.ruchij.services.messages.models.Message.{Group, HeartBeat, OneToOne}

case class OutboundMessage(messageType: MessageType, message: Message)

object OutboundMessage {
  def messageType(message: Message): MessageType =
    message match {
      case _: OneToOne => MessageType.OneToOne
      case _: Group => MessageType.GroupMessage
      case _: HeartBeat => MessageType.HeartBeat
    }

  def fromMessage(message: Message): OutboundMessage =
    OutboundMessage(messageType(message), message)

}
