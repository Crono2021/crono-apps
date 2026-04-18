.class public Lorg/drinkless/tdlib/TdApi$GroupCallId;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCallId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x14e4bb45


# instance fields
.field public id:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14190
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14191
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 14181
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14182
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GroupCallId;->id:I

    .line 14183
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14187
    const v0, 0x14e4bb45

    return v0
.end method
