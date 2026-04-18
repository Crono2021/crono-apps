.class public Lorg/drinkless/tdlib/TdApi$Call;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Call"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x36db9764


# instance fields
.field public id:I

.field public isOutgoing:Z

.field public isVideo:Z

.field public state:Lorg/drinkless/tdlib/TdApi$CallState;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46656
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46657
    return-void
.end method

.method public constructor <init>(IJZZLorg/drinkless/tdlib/TdApi$CallState;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z
    .param p6, "callState"    # Lorg/drinkless/tdlib/TdApi$CallState;

    .line 46643
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46644
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Call;->id:I

    .line 46645
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$Call;->userId:J

    .line 46646
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$Call;->isOutgoing:Z

    .line 46647
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$Call;->isVideo:Z

    .line 46648
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$Call;->state:Lorg/drinkless/tdlib/TdApi$CallState;

    .line 46649
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46653
    const v0, 0x36db9764

    return v0
.end method
