.class public Lorg/drinkless/tdlib/TdApi$GetChatMember;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatMember"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatMember;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f3ead8e


# instance fields
.field public chatId:J

.field public memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25825
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 25814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25815
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatMember;->chatId:J

    .line 25816
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatMember;->memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 25817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25821
    const v0, -0x2f3ead8e

    return v0
.end method
