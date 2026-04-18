.class public Lorg/drinkless/tdlib/TdApi$ForwardSource;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ForwardSource"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6b02aec9


# instance fields
.field public chatId:J

.field public date:I

.field public isOutgoing:Z

.field public messageId:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public senderName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49759
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;IZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p6, "str"    # Ljava/lang/String;
    .param p7, "i9"    # I
    .param p8, "z8"    # Z

    .line 49744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49745
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ForwardSource;->chatId:J

    .line 49746
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ForwardSource;->messageId:J

    .line 49747
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ForwardSource;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 49748
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$ForwardSource;->senderName:Ljava/lang/String;

    .line 49749
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ForwardSource;->date:I

    .line 49750
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ForwardSource;->isOutgoing:Z

    .line 49751
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49755
    const v0, 0x6b02aec9

    return v0
.end method
