.class public Lorg/drinkless/tdlib/TdApi$BusinessMessage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59fb9ba


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;

.field public replyToMessage:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23385
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p2, "message2"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 23374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23375
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessMessage;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 23376
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessMessage;->replyToMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 23377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23381
    const v0, -0x59fb9ba

    return v0
.end method
