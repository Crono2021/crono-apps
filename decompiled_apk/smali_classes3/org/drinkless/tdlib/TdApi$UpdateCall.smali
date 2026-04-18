.class public Lorg/drinkless/tdlib/TdApi$UpdateCall;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4fb3d0dd


# instance fields
.field public call:Lorg/drinkless/tdlib/TdApi$Call;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21602
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21603
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Call;)V
    .locals 0
    .param p1, "call"    # Lorg/drinkless/tdlib/TdApi$Call;

    .line 21593
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21594
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateCall;->call:Lorg/drinkless/tdlib/TdApi$Call;

    .line 21595
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21599
    const v0, 0x4fb3d0dd

    return v0
.end method
