.class public Lorg/drinkless/tdlib/TdApi$Error;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Error"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x642270e6


# instance fields
.field public code:I

.field public message:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25465
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 25454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25455
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Error;->code:I

    .line 25456
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Error;->message:Ljava/lang/String;

    .line 25457
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25461
    const v0, -0x642270e6

    return v0
.end method
