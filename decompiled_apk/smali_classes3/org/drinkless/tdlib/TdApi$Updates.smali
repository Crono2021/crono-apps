.class public Lorg/drinkless/tdlib/TdApi$Updates;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Updates"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1c5cc72b


# instance fields
.field public updates:[Lorg/drinkless/tdlib/TdApi$Update;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22269
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Update;)V
    .locals 0
    .param p1, "updateArr"    # [Lorg/drinkless/tdlib/TdApi$Update;

    .line 22259
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22260
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Updates;->updates:[Lorg/drinkless/tdlib/TdApi$Update;

    .line 22261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22265
    const v0, 0x1c5cc72b

    return v0
.end method
