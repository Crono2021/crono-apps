.class public Lorg/drinkless/tdlib/TdApi$TextEntities;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextEntities"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x379f7d44


# instance fields
.field public entities:[Lorg/drinkless/tdlib/TdApi$TextEntity;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21206
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21207
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$TextEntity;)V
    .locals 0
    .param p1, "textEntityArr"    # [Lorg/drinkless/tdlib/TdApi$TextEntity;

    .line 21197
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21198
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TextEntities;->entities:[Lorg/drinkless/tdlib/TdApi$TextEntity;

    .line 21199
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21203
    const v0, -0x379f7d44

    return v0
.end method
