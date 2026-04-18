.class public Lorg/drinkless/tdlib/TdApi$SuggestUserBirthdate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestUserBirthdate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25ad2b5


# instance fields
.field public birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32928
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32929
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Birthdate;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "birthdate"    # Lorg/drinkless/tdlib/TdApi$Birthdate;

    .line 32918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32919
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestUserBirthdate;->userId:J

    .line 32920
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SuggestUserBirthdate;->birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;

    .line 32921
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32925
    const v0, 0x25ad2b5

    return v0
.end method
