.class public Lorg/drinkless/tdlib/TdApi$ToggleUsernameIsActive;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleUsernameIsActive"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a276de3


# instance fields
.field public isActive:Z

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33529
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 33518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33519
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleUsernameIsActive;->username:Ljava/lang/String;

    .line 33520
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleUsernameIsActive;->isActive:Z

    .line 33521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33525
    const v0, 0x4a276de3    # 2743160.8f

    return v0
.end method
