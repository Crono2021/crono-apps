.class public Lorg/drinkless/tdlib/TdApi$UpdateGroupCallNewMessage;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateGroupCallNewMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x8a42b60


# instance fields
.field public groupCallId:I

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41626
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41627
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 41615
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41616
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallNewMessage;->groupCallId:I

    .line 41617
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallNewMessage;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 41618
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallNewMessage;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 41619
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41623
    const v0, 0x8a42b60

    return v0
.end method
