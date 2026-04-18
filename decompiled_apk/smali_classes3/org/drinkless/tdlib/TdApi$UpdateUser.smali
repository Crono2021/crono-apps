.class public Lorg/drinkless/tdlib/TdApi$UpdateUser;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x468928f9


# instance fields
.field public user:Lorg/drinkless/tdlib/TdApi$User;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22232
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22233
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$User;)V
    .locals 0
    .param p1, "user"    # Lorg/drinkless/tdlib/TdApi$User;

    .line 22223
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22224
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateUser;->user:Lorg/drinkless/tdlib/TdApi$User;

    .line 22225
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22229
    const v0, 0x468928f9

    return v0
.end method
