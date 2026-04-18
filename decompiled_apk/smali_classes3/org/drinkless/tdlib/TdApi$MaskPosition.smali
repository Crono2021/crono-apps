.class public Lorg/drinkless/tdlib/TdApi$MaskPosition;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MaskPosition"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7d0449c2


# instance fields
.field public point:Lorg/drinkless/tdlib/TdApi$MaskPoint;

.field public scale:D

.field public xShift:D

.field public yShift:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44142
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44143
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MaskPoint;DDD)V
    .locals 0
    .param p1, "maskPoint"    # Lorg/drinkless/tdlib/TdApi$MaskPoint;
    .param p2, "d9"    # D
    .param p4, "d10"    # D
    .param p6, "d11"    # D

    .line 44130
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44131
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MaskPosition;->point:Lorg/drinkless/tdlib/TdApi$MaskPoint;

    .line 44132
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MaskPosition;->xShift:D

    .line 44133
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$MaskPosition;->yShift:D

    .line 44134
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$MaskPosition;->scale:D

    .line 44135
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44139
    const v0, -0x7d0449c2

    return v0
.end method
