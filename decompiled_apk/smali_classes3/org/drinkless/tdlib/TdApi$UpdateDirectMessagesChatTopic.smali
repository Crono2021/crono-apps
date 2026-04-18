.class public Lorg/drinkless/tdlib/TdApi$UpdateDirectMessagesChatTopic;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateDirectMessagesChatTopic"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x28bb0c13


# instance fields
.field public topic:Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21728
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21729
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;)V
    .locals 0
    .param p1, "directMessagesChatTopic"    # Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;

    .line 21719
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21720
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateDirectMessagesChatTopic;->topic:Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;

    .line 21721
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21725
    const v0, -0x28bb0c13

    return v0
.end method
