.class public Lorg/drinkless/tdlib/TdApi$UpdateConnectionState;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateConnectionState"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x57939e2e


# instance fields
.field public state:Lorg/drinkless/tdlib/TdApi$ConnectionState;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21639
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ConnectionState;)V
    .locals 0
    .param p1, "connectionState"    # Lorg/drinkless/tdlib/TdApi$ConnectionState;

    .line 21629
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21630
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateConnectionState;->state:Lorg/drinkless/tdlib/TdApi$ConnectionState;

    .line 21631
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21635
    const v0, 0x57939e2e

    return v0
.end method
