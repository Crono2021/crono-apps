.class public Lorg/drinkless/tdlib/TdApi$ReportMessageReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportMessageReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x36c88827


# instance fields
.field public chatId:J

.field public messageId:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39624
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39625
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 39613
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39614
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportMessageReactions;->chatId:J

    .line 39615
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ReportMessageReactions;->messageId:J

    .line 39616
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ReportMessageReactions;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 39617
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39621
    const v0, 0x36c88827

    return v0
.end method
