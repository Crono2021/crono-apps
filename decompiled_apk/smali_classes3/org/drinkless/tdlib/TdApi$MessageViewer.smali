.class public Lorg/drinkless/tdlib/TdApi$MessageViewer;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageViewer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56f111cd


# instance fields
.field public userId:J

.field public viewDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28765
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 28754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28755
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageViewer;->userId:J

    .line 28756
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$MessageViewer;->viewDate:I

    .line 28757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28761
    const v0, 0x56f111cd

    return v0
.end method
