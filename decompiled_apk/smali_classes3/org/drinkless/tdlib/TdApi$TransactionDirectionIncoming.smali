.class public Lorg/drinkless/tdlib/TdApi$TransactionDirectionIncoming;
.super Lorg/drinkless/tdlib/TdApi$TransactionDirection;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TransactionDirectionIncoming"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10284337


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 7910
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TransactionDirection;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 7915
    const v0, -0x10284337

    return v0
.end method
