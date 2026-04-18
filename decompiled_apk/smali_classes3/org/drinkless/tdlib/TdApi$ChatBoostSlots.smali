.class public Lorg/drinkless/tdlib/TdApi$ChatBoostSlots;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostSlots"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c7f2815


# instance fields
.field public slots:[Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9745
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;)V
    .locals 0
    .param p1, "chatBoostSlotArr"    # [Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;

    .line 9735
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9736
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSlots;->slots:[Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;

    .line 9737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9741
    const v0, 0x3c7f2815

    return v0
.end method
