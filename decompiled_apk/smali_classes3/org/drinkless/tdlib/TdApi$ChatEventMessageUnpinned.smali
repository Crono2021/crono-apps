.class public Lorg/drinkless/tdlib/TdApi$ChatEventMessageUnpinned;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMessageUnpinned"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x166bc4e9


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10015
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 10005
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10006
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessageUnpinned;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 10007
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10011
    const v0, -0x166bc4e9    # -2.2400008E25f

    return v0
.end method
