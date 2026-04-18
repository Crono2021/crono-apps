.class public Lorg/drinkless/tdlib/TdApi$UpdateNewMessage;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x21904df2


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21890
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21891
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 21881
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21882
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewMessage;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 21883
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21887
    const v0, -0x21904df2

    return v0
.end method
