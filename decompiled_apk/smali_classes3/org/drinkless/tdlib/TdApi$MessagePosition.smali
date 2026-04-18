.class public Lorg/drinkless/tdlib/TdApi$MessagePosition;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePosition"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4d0540ef


# instance fields
.field public date:I

.field public messageId:J

.field public position:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38590
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38591
    return-void
.end method

.method public constructor <init>(IJI)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "i10"    # I

    .line 38579
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38580
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePosition;->position:I

    .line 38581
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MessagePosition;->messageId:J

    .line 38582
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$MessagePosition;->date:I

    .line 38583
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38587
    const v0, 0x4d0540ef    # 1.3972658E8f

    return v0
.end method
