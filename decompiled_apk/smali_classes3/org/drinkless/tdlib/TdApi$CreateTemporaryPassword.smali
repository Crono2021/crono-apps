.class public Lorg/drinkless/tdlib/TdApi$CreateTemporaryPassword;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateTemporaryPassword"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TemporaryPasswordState;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x60f2907a


# instance fields
.field public password:Ljava/lang/String;

.field public validFor:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24745
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 24734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24735
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateTemporaryPassword;->password:Ljava/lang/String;

    .line 24736
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$CreateTemporaryPassword;->validFor:I

    .line 24737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24741
    const v0, -0x60f2907a

    return v0
.end method
