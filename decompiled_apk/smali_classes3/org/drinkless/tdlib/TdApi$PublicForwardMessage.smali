.class public Lorg/drinkless/tdlib/TdApi$PublicForwardMessage;
.super Lorg/drinkless/tdlib/TdApi$PublicForward;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PublicForwardMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x317b3d2


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17988
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PublicForward;-><init>()V

    .line 17989
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 17979
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PublicForward;-><init>()V

    .line 17980
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PublicForwardMessage;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 17981
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17985
    const v0, 0x317b3d2

    return v0
.end method
