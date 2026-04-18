.class public Lorg/drinkless/tdlib/TdApi$ChatEventMessagePinned;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMessagePinned"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1a26ad1a


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9996
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9997
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 9987
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9988
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessagePinned;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 9989
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9993
    const v0, 0x1a26ad1a

    return v0
.end method
