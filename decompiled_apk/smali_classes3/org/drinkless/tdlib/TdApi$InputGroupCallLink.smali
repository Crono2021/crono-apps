.class public Lorg/drinkless/tdlib/TdApi$InputGroupCallLink;
.super Lorg/drinkless/tdlib/TdApi$InputGroupCall;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputGroupCallLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x30688a28


# instance fields
.field public link:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14676
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputGroupCall;-><init>()V

    .line 14677
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14667
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputGroupCall;-><init>()V

    .line 14668
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputGroupCallLink;->link:Ljava/lang/String;

    .line 14669
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14673
    const v0, -0x30688a28

    return v0
.end method
