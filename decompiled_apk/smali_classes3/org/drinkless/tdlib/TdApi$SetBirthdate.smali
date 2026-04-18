.class public Lorg/drinkless/tdlib/TdApi$SetBirthdate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBirthdate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4ea9dd98


# instance fields
.field public birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19465
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Birthdate;)V
    .locals 0
    .param p1, "birthdate"    # Lorg/drinkless/tdlib/TdApi$Birthdate;

    .line 19455
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19456
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBirthdate;->birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;

    .line 19457
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19461
    const v0, 0x4ea9dd98

    return v0
.end method
