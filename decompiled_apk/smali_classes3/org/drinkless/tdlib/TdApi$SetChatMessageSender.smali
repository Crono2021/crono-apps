.class public Lorg/drinkless/tdlib/TdApi$SetChatMessageSender;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatMessageSender"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x54ba9482


# instance fields
.field public chatId:J

.field public messageSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31308
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31309
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 31298
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31299
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatMessageSender;->chatId:J

    .line 31300
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatMessageSender;->messageSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 31301
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31305
    const v0, -0x54ba9482

    return v0
.end method
