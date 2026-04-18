.class public Lorg/drinkless/tdlib/TdApi$UpdateBasicGroup;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateBasicGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3bcc389d


# instance fields
.field public basicGroup:Lorg/drinkless/tdlib/TdApi$BasicGroup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21566
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21567
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BasicGroup;)V
    .locals 0
    .param p1, "basicGroup"    # Lorg/drinkless/tdlib/TdApi$BasicGroup;

    .line 21557
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21558
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateBasicGroup;->basicGroup:Lorg/drinkless/tdlib/TdApi$BasicGroup;

    .line 21559
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21563
    const v0, -0x3bcc389d

    return v0
.end method
